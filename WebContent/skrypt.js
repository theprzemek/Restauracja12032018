function czyWypelnione(pole){
	if(pole.value==""||!/[a-z]/.test(pole.value)){
		document.getElementById("i"+pole.id).innerHTML= "To pole ma niepoprawną wartość";		
		return false;
	}else{
		document.getElementById("i"+pole.id).innerHTML= "";		
		return true;
	}
	
}
function czyPoprawnyEmail(email) {
     var re =/[^\s@]+@[^\s@]+\.[^\s@]+/;
	 if(re.test(email.value)){
		 document.getElementById("i"+email.id).innerHTML= "email poprawny";	
    return true;
	 }else{
		 document.getElementById("i"+email.id).innerHTML= "email niepoprawny";	
		 return false;
	 }
}
function czyPoprawnaData(pole){
	if(pole.value==""||!/^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](201[89]|20[2-9][0-9])$/.test(pole.value)){
		document.getElementById("i"+pole.id).innerHTML= "To pole ma niepoprawną wartość";		
		return false;
	}else{
		document.getElementById("i"+pole.id).innerHTML= "";		
		return true;
	}
}
function czyPoprawnaGodz(pole){
	if(pole.value==""||!/^(0[8-9]|1[0-9]|2[0-2])[:][0-5][0-9]$/.test(pole.value)){
		document.getElementById("i"+pole.id).innerHTML= "To pole ma niepoprawną wartość";		
		return false;
	}else{
		document.getElementById("i"+pole.id).innerHTML= "";		
		return true;
	}
}
function wyczyscBledy(){
	document.getElementById(iname.id).innerHTML= "";	
	document.getElementById(ilname.id).innerHTML= "";	
	document.getElementById(iemail.id).innerHTML= "";	
	document.getElementById(idata.id).innerHTML= "";	
document.getElementById(igodz.id).innerHTML= "";	
	}
window.onload = function(){
	
	document.getElementById("rezerwacja").onsubmit= function(){
		
		
		if(czyWypelnione(this.name)&czyWypelnione(this.lname)&czyPoprawnyEmail(this.email)&czyPoprawnaData(this.data)&czyPoprawnaGodz(this.godz)){
			return true;
		}else{
			return false;
		}
		
	}
	document.getElementById("rezerwacja").onreset= function(){
		wyczyscBledy();
	}
	
}