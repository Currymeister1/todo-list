export interface Task{
    id?: number,
    name: string,
    description?: string,
    start?: Date,
    end: Date,
    issuer: string,
    category: string
}