#include<stdio.h>
#include<iostream>
using namespace std;
struct Y
{
char s;
int b;
int t=0;
};
int main(){
int i,j,n,ad;
Y d,f[52];
for(i=0;i<4;i++){
	for(j=0;j<13;j++){
		ad=i*13+j;
		if(i==0)
			f[ad].s='S';
		else if(i==1)
			f[ad].s='H';
		else if(i==2)
			f[ad].s='C';
		else
			f[ad].s='D';
		f[ad].b=j+1;
	}
}
scanf("%d",&n);
for(i=0;i<n;i++){

	scanf( "%c" ,&d.s ) ;

	scanf("%c %d",&d.s,&d.b);

	for(j=0;j<52;j++){
		if(d.b==f[j].b&&d.s==f[j].s){
			f[j].t=1;
		}
	}
}
for(i=0;i<52;i++){	
	if(f[i].t==0){
		printf("%c %d\n",f[i].s,f[i].b);
	}
}
return 0;
}