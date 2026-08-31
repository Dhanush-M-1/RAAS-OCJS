#include <cstdio>
#include <cstdlib>

int n, m;
int a[50], b[50], c[50], d[50];

int main(){
	scanf("%d %d", &n, &m);
	for(int i=0; i<n; ++i) scanf("%d %d", &a[i], &b[i]);
	for(int i=0; i<m; ++i) scanf("%d %d", &c[i], &d[i]);
	for(int i=0; i<n; ++i){
		int tmp = 1e9;
		int ans = -1;
		for(int j=0; j<m; ++j){
			int dist = abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(dist < tmp){
				tmp = dist;
				ans = j+1;
			}
		}
		printf("%d\n", ans);
	}
}