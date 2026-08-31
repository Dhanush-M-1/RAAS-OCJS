#include<stdio.h>
int main(void){
	char card[52],card2[4]={'S','H','C','D'};
	int kazu[52],maisu,i,t,r=0,y,nai=0;
	scanf("%d",&maisu);
	for(i=0;i<maisu;i++){
		scanf("%s %d",&card[i],&kazu[i]);
	}
	for(i=0;i<4;i++){
			for(t=1;t<=13;t++){
				for(y=0;y<maisu;y++){
					if(card2[i]==card[y]&&t==kazu[y]){
					r++;
					
					}
				
				}
					if(r!=1){
						printf("%c %d\n",card2[i],t);
						
					}
				r=0;
			}
		
		}
	
	return 0;
}