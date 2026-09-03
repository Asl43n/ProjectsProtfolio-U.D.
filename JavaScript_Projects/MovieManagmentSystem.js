/**
 * Coding Project ausgeführt durch die Lernplattform Coddy
 *
 */

const festivalData = {
                    movies: [{
                        id: 1,
                        title: "Inception",
                        director: "Christopher Nolan",
                        year: 2010,
                        mainGenre: "Sci-Fi",
                        secondGenre: undefined,
                        avgRating: 0,
                        available: true
                    }],
                    venues: [{
                        id: 1,
                        name: "Main Theater",
                        capacity: 200,
                    }],
                    screenings: [{
                        id: 1,
                        movieId: 1,
                        venueId: 1,
                        date: '2023-10-29',
                        time: '13:35:00',
                        availableSeats: 200
                    }],
                    tickets: new Set()
                }; // Fill initial data

function manageFestival(actions, data) {
    let results = [];
    
    actions.forEach((action, index) => {
        const currentData = data[index];
        
        switch(action) {
            case "listMovies":
               results.push(festivalData.movies)
            break
            case "listVenues":
               results.push(festivalData.venues)
                break
            case "listTickets":
                results.push(festivalData.tickets) 
                break
            case "listScreenings":
                results.push(festivalData.screenings)
                break
            case "addMovie":    
                festivalData.movies.push({
                    "id": festivalData.movies.length + 1,
                    "title": currentData.title,
                    "director": currentData.director,
                    "year": currentData.year,
                    "mainGenre": currentData.mainGenre,
                    "secondGenre": currentData.secondGenre,
                    "avgRating": 0,
                    "available": true
                })
                results.push("Movie added successfully!")
                break
            case "addVenue":
                festivalData.venues.push({
                    "id": festivalData.venues.length +1,
                    "name": currentData.name,
                    "capacity": currentData.capacity
                })
                results.push("Venue added successfully!")
                break
            case "addScreening":
                let hasMovie = festivalData.movies.find(movie => movie.id === currentData.movieId)
                let hasVenue = festivalData.venues.find(venue => venue.id === currentData.venueId)
                if (!(hasMovie && hasVenue)){
                      results.push("Movie or venue not found!")

                }
                else if (festivalData.screenings.some(screening =>
                    screening.venueId === currentData.venueId 
                    && screening.time === currentData.time 
                    && screening.date === currentData.date)){
                    results.push("Screening already exists at this time!")
                }
                else{
                    festivalData.screenings.push({
                    "id": festivalData.screenings.length +1 ,
                    "movieId": currentData.movieId,
                    "venueId": currentData.venueId,
                    "date": currentData.date,
                    "time": currentData.time,
                    "availableSeats": hasVenue.capacity
                })
                    results.push("Screening added successfully!")
                }
                
                break 
            case "buyTicket": 
                    let screeningExist = festivalData.screenings.find(screen => screen.id === currentData.screeningId)
                    if(!screeningExist ){
                        results.push("Screening not found!")
                        break
                    }
                    else if (screeningExist.availableSeats < currentData.quantity){
                        results.push("Not enough seats available!")
                        break
                    }
                    else{
                        let currentAvailableSeats = screeningExist.availableSeats
                        for(let i = 0; i < currentData.quantity; i++){
                            festivalData.tickets.add(
                                `${currentData.screeningId}-${currentAvailableSeats}`
                            ) 
                            currentAvailableSeats--
                        }
                        screeningExist.availableSeats = screeningExist.availableSeats - currentData.quantity
                        results.push("Tickets purchased successfully!")
                    }
                    break
                case "rateMovie":

                    let movie = festivalData.movies.find(movie => movie.id === currentData.movieId)
                    if(!movie){
                        results.push("Movie not found!")
                    }  
                    else if (!(currentData.avgRating >= 1 && currentData.avgRating <= 5)){
                        results.push("Invalid rating! Must be between 1 and 5")
                    }
                    else {
                        movie.avgRating = currentData.avgRating
                        results.push("Rating added successfully!")
                    }
                    break 
                case "cancelScreening": 
                    let screen = festivalData.screenings.find(screen => screen.id === currentData.screeningId);
                    if(!screen){
                        results.push("Screening not found!")
                        break
                    }
                    else{
                        let indexScreen = festivalData.screenings.findIndex(screen => screen.id === currentData.screeningId)
                        festivalData.screenings.splice(indexScreen ,1)
                        festivalData.tickets.forEach(ticket => {
                           if( ticket.startsWith(`${currentData.screeningId}`)){
                            festivalData.tickets.delete(ticket)
                           }
                        })
                        results.push("Screening cancelled successfully!")
                    }
                    break
            default:
                results.push("Invalid action!");
        }
    });
    
    return results;
}