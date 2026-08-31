#include<cstdio>
#include<cmath>
#include <stdlib.h>

float spase(float a,float b,float c){
	return sqrt((a+b+c)*(b-a+c)*(a-b+c)*(a+b-c));
}

int main(){
	float a,b,c,d,e,f,g,h,AB,BC,CD,DA,AC,BD,abc,bcd,cda,dab;
	while( scanf("%f,%f,%f,%f,%f,%f,%f,%f",&a,&b,&c,&d,&e,&f,&g,&h) != EOF ){
		AB=sqrt((a-c)*(a-c)+(b-d)*(b-d));
		BC=sqrt((c-e)*(c-e)+(d-f)*(d-f));
		CD=sqrt((e-g)*(e-g)+(f-h)*(f-h));
		DA=sqrt((g-a)*(g-a)+(h-b)*(h-b));
		AC=sqrt((a-e)*(a-e)+(b-f)*(b-f));
		BD=sqrt((c-g)*(c-g)+(d-h)*(d-h));
		abc=((a-c)*(c-e)+(b-d)*(d-f))/AB/BC;
		bcd=((c-e)*(e-g)+(d-f)*(f-h))/BC/CD;
		cda=((e-g)*(g-a)+(f-h)*(h-b))/CD/DA;
		dab=((g-a)*(a-c)+(h-b)*(b-d))/DA/AB;
		//printf("%f %f %f %f\n",abc,bcd,cda,dab);
		//printf("%f %f %f %f\n",acos(abc),acos(bcd),acos(cda),acos(dab));
		abc=acos(abc)+acos(bcd)+acos(cda)+acos(dab);
		//printf("%f %f %f %f\n",abc,2*M_PI,spase(AB,BC,AC)+spase(CD,DA,AC),spase(DA,AB,BD)+spase(CD,BC,BD));
		//printf("%d %d\n",abs(abc-2*M_PI)<0.0001,abs(spase(AB,BC,AC)+spase(CD,DA,AC)-spase(DA,AB,BD)-spase(CD,BC,BD))<0.0001);
		if(((abs(abc-2*M_PI)<0.0001))&&(abs(spase(AB,BC,AC)+spase(CD,DA,AC)-spase(DA,AB,BD)-spase(CD,BC,BD))<0.0001)){
			printf("YES\n");
		}
		else{
			printf("NO\n");
		}
	}
	return 0;
}