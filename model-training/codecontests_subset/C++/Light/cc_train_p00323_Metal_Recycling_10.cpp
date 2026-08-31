#include <stdio.h>
#include <cmath>
#include <algorithm>
#include <stack>
#include <queue>
#include <vector>
typedef long long int ll;

using namespace std;

int main(){

	int N,table[200030],a,b,S,tmp;

	for(int i = 0; i < 200030; i++)table[i] = 0;

	scanf("%d",&N);

	for(int loop = 0; loop < N; loop++){
		scanf("%d %d",&a,&b);
		table[a+b]++;
	}

	for(int i = 0; i < 200030; i++){
		if(table[i] != 0){ //?????°???????§£??????
			tmp = table[i];
			table[i] = 0;
			S = 2;
			for(int k = 0; tmp != 0;k++,tmp /= S){
				if(tmp%S == 1){
					table[i+k]++;
				}
			}
		}
	}

	for(int i = 0; i < 200030; i++){
		if(table[i] != 0){
			printf("%d 0\n",i); //0??§????????????1??????2????????§???0
		}
	}

    return 0;
}