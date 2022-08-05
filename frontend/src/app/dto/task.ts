export interface Task{
    id?: number;
    name: string;
    description?: string;
    started?: Date;
    ended: Date;
    issuer: string;
    category: string;
    group: string;
}
