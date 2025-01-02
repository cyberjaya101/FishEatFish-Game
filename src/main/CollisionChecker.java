package main;

import Entity.Entity;
import Entity.Fish1;
import enemy.Enemy1;


public class CollisionChecker {
    
    GamePanel gp;
    
    Enemy1 enemy1 = new Enemy1(gp);
    
    
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    //ENEMY COLLISION
    public int checkEntity(Entity entity, Entity[] target) {
            
        
        int index = 999;
        
        for(int i = 0; i < target.length; i++) {
            
            if(target[i] != null) {
                //get entity's solid area position
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                //get the ENEMY solid area position
                target[i].solidArea.x = target[i].x + target[i].solidArea.x;
                target[i].solidArea.y = target[i].y + target[i].solidArea.y;
                
                switch(entity.direction) {
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                                entity.collisionOn = true;
                                index = i;
                                
                                
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                                entity.collisionOn = true;
                                index = i;
                                
                        }
                        break;
                }
                
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }
        
        return index;
    }
    public int checkEntity2(Entity entity, Entity[] target) {
        
        int index = 999;
        
        for(int i = 3; i <= 6; i++) {
            if(target[i] != null) {
                //get entity's solid area position
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                //get the ENEMY solid area position
                target[i].solidArea.x = target[i].x + target[i].solidArea.x;
                target[i].solidArea.y = target[i].y + target[i].solidArea.y;
                
                switch(entity.direction) {
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                                entity.collisionOn = true;
                                index = i;
                                
                                
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                                entity.collisionOn = true;
                                index = i;
                                
                        }
                        break;
                }
                
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }
        
        return index;
    }
    public int checkEntity3(Entity entity, Entity[] target) {
        
        int index = 999;
        
        for(int i = 7; i <=10 ; i++) {
            if(target[i] != null) {
                //get entity's solid area position
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                //get the ENEMY solid area position
                target[i].solidArea.x = target[i].x + target[i].solidArea.x;
                target[i].solidArea.y = target[i].y + target[i].solidArea.y;
                
                switch(entity.direction) {
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                                entity.collisionOn = true;
                                index = i;
                                
                                
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                                entity.collisionOn = true;
                                index = i;
                                
                        }
                        break;
                }
                
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }
        
        return index;
    }
    public int checkEntity4(Entity entity, Entity[] target) {
        
        int index = 999;
        
        for(int i = 11; i <=13 ; i++) {
            if(target[i] != null) {
                //get entity's solid area position
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                //get the ENEMY solid area position
                target[i].solidArea.x = target[i].x + target[i].solidArea.x;
                target[i].solidArea.y = target[i].y + target[i].solidArea.y;
                
                switch(entity.direction) {
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                                entity.collisionOn = true;
                                index = i;
                                
                                
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                                entity.collisionOn = true;
                                index = i;
                                
                        }
                        break;
                }
                
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }
        
        return index;
    }
    
//    public boolean checkPlayer(Entity entity) {
//        
//        int index = 999;
//        
//                //get entity's solid area position
//                entity.solidArea.x = entity.x + entity.solidArea.x;
//                entity.solidArea.y = entity.y + entity.solidArea.y;
//                //get the ENEMY solid area position
//                gp.fish1.solidArea.x = gp.fish1.x + gp.fish1.solidArea.x;
//                gp.fish1.solidArea.y = gp.fish1.y + gp.fish1.solidArea.y;
//                
//                switch(entity.direction) {
//                    case "left":
//                        entity.solidArea.x -= entity.speed;
//                        if(entity.solidArea.intersects(gp.fish1.solidArea)) {
//                                entity.collisionOn = true;
//                                index = 1;
//                                
//                        }
//                        break;
//                    case "right":
//                        entity.solidArea.x += entity.speed;
//                        if(entity.solidArea.intersects(gp.fish1.solidArea)) {
//                                entity.collisionOn = true;
//                                index = 1;
//                                
//                        }
//                        break;
//                }
//                
//                entity.solidArea.x = entity.solidAreaDefaultX;
//                entity.solidArea.y = entity.solidAreaDefaultY;
//                gp.fish1.solidArea.x = gp.fish1.solidAreaDefaultX;
//                gp.fish1.solidArea.y = gp.fish1.solidAreaDefaultY;
//    
//        
//        return entity.collisionOn;
//}
}