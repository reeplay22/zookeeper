//beforeEach(function () {
//    browser.get('http://localhost:8080/index.html');
//});

//describe('ZooKeeper', function () {
//    it('should have a title', function () {
//        expect(browser.getTitle()) == "The Zookeepr";
//    });
//});



//describe('Zookeeper', function () {
//    it('should navigate properly', function () {
//        
//        browser.get('http://localhost:8080/index.html');
//    element(by.id('#logTab')).click();
//         browser.driver.sleep(1500);  
//    element(by.id('#createTab')).click();
//         browser.driver.sleep(1500); 
//    element(by.id('#updateTab')).click();
//         browser.driver.sleep(1500);
//    });
//});

describe('Zookeeper', function(){
    it('should create a enclosure with new animal', function(){
        
        //element(by.id('#createTab')).click();
         browser.driver.sleep(1500); 
        browser.getAbsUrl('http://localhost:8080/index.html');
        browser.driver.sleep(3000);
       
        element(by.model('enclosure.enclosureName')).sendKeys('bear cage');
        browser.driver.sleep(500); 
        
        element(by.model('enclosure.enclosureCondition')).sendKeys('good');
        browser.driver.sleep(500); 
        
        element(by.model('enclosure.numberOfAnimals')).sendKeys(3);
        browser.driver.sleep(500);
        
        element(by.css('#createAnimal')).click();
        browser.driver.sleep(500);             
        
        element(by.model('animal.commonName')).sendKeys('bear');
        browser.driver.sleep(500);
        
        element(by.model('animal.scientificName')).sendKeys('big dog in the gym');
        browser.driver.sleep(500);
        
        element(by.css('#addFavoriteFood')).click();
        browser.driver.sleep(500);
        
                
        element.all(by.options('favoriteFood.name for favoriteFood in favoriteFoods')).last();
        browser.driver.sleep(500);     
       
        element(by.model('animal.infoLink')).sendKeys('bears.com'); 
        browser.driver.sleep(500);
        
        element(by.css('#saveAnimalButton')).click();
        browser.driver.sleep(1500);
        
        var animalMessage = element(by.exactBinding('animalResponseMessage')).isPresent();
        
        expect(animalMessage).toBe(true);
         browser.driver.sleep(1500);
       
        element(by.css('#addAnimal')).click();       
         browser.driver.sleep(500);
       
        element.all(by.options('animal.commonName for animal in animal"')).last();
        browser.driver.sleep(500);
        
        element(by.css('#saveEnclosureButton')).click();
        browser.driver.sleep(500);
        
        var enclosureMessage = element(by.exactBinding('enclosureMessage')).isPresent();
        
         expect(enclosureMessage).toBe(true);
               
    });
    
});

describe('Zookeeper', function(){
    it('should update a enclosure with new animal', function(){
       
        element.all(by.options('enclosure.enclosureName for enclosure in enclosures')).last();
        
        
    });

}):