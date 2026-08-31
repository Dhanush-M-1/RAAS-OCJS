#include <cstdio>
#include <vector>
using namespace std;

int main(){
	int n;
	while(scanf("%d", &n), n){
		vector<int> v(n);
		for(int i = 0; i < n; ++i){
			scanf("%d", &v[i]);
		}

		int ans = 0;
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < i; ++j){
				if(v[j] > v[i]){
					++ans;
				}
			}
		}
		printf("%d\n", ans);
	}
}