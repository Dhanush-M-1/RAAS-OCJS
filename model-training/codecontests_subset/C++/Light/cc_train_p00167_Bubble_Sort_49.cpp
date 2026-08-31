#include<stdio.h>
int table[100];
int main(){
	int a;
	while(scanf("%d",&a),a){
		for(int i=0;i<a;i++)scanf("%d",table+i);
		int ret=0;
		for(int i=0;i<a;i++){
			for(int j=0;j<a-1;j++){
				if(table[j]>table[j+1]){
					ret++;
					int val=table[j];
					table[j]=table[j+1];
					table[j+1]=val;
				}
			}
		}
		printf("%d\n",ret);
	}
}