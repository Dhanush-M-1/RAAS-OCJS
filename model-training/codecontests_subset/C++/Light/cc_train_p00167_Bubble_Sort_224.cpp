#include <stdio.h>
#include<math.h>
#include <algorithm>
using namespace std;

int main(){
	int n,table[100],count;

	while(true){
		scanf("%d",&n);
		if(n == 0)break;

		for(int i=0; i < n; i++){
			scanf("%d",&table[i]);
		}

		count = 0;

		for(int i=n-2; i >= 0; i--){
			for(int k=0; k <= i; k++){
				if(table[k] > table[k+1]){
					swap(table[k],table[k+1]);
					count++;
				}
			}
		}

		printf("%d\n",count);
	}
    return 0;
}