export default class Bathroom {
    constructor(
        id,
        name,
        street,
        city,
        state,
        accessible,
        unisex,
        directions,
        comment,
        latitude,
        longitude,
        created_at,
        updated_at,
        downvote,
        upvote,
        country,
        changing_table,
        distance,
        bearing
    ) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.accessible = accessible;
        this.unisex = unisex;
        this.directions = directions;
        this.comment = comment;
        this.latitude = latitude;
        this.longitude = longitude;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.downvote = downvote;
        this.upvote = upvote;
        this.country = country;
        this.changing_table = changing_table;
        this.distance = distance;
        this.bearing = bearing;
    }
}