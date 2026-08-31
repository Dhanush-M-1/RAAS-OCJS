#include"bits/stdc++.h"
#define rep(i,n) for(int i=0;i<n;i++)
typedef long long ll;
using namespace std;

char c[40][15];

int main(){
	int n;
	while (scanf("%d", &n), n){
		int want[] = { 5, 7, 5, 7, 7 };
		int cnt = 0;
		int j = 0;
		for (int i = 0; i < n; i++){
			scanf("%s", c[i]);
		}
		int t;
		for (t = 0; t < n; t++){
			for (int i = t; i < n; i++){
				cnt += strlen(c[i]);
				if (cnt == want[j]){
					cnt = 0;
					if (++j == 5)break;
				}
				if (cnt > want[j])break;
			}
			if (j == 5)break;
			j = 0;
			cnt = 0;
		}
		printf("%d\n", t+1);
	}
	return 0;
}