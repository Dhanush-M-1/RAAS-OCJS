#include <cstdio>

int n;
int card[52];
char c;
int a;

int main(){
	scanf("%d", &n);
	for(int i=0; i<n; ++i){
		scanf(" %c%d", &c, &a);
		if(c=='S'){
			card[a-1]=1;
		}else if(c=='H'){
			card[a-1+13]=1;
		}else if(c=='C'){
			card[a-1+26]=1;
		}else if(c=='D'){
			card[a-1+39]=1;	
		}
	}
	
	for(int i=0; i<52; ++i){
		if(card[i]==0){
			if(i<13){
				printf("S ");
			}else if(i<26){
				printf("H ");
			}else if(i<39){
				printf("C ");
			}else if(i<52){
				printf("D ");
			}
			printf("%d\n", i%13+1);
		}
	}
}
