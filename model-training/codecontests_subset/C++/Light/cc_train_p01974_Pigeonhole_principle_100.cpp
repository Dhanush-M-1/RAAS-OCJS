#include <stdio.h>
#include <cmath>
#include <algorithm>
#include <cfloat>
#include <stack>
#include <queue>
#include <vector>
#include <string>
#include <iostream>
#include <set>
#include <map>
#include <time.h>
typedef long long int ll;
typedef unsigned long long int ull;
#define BIG_NUM 2000000000
#define MOD 1000000007
#define EPS 0.000000001
using namespace std;


int main(){

	int N;
	scanf("%d",&N);

	int table[N];
	for(int i = 0; i < N; i++)scanf("%d",&table[i]);

	for(int i = 0; i < N-1; i++){
		for(int k = i+1; k < N; k++){
			if(abs(table[i]-table[k])%(N-1) == 0){
				printf("%d %d\n",table[i],table[k]);
				return 0;
			}
		}
	}

	return 0;
}

