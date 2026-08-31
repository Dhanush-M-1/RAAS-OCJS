#include <iostream>
using namespace std;

int main(){
	int N, M, a[100], b[100], c[100], d[100], s, ans, i, j;
	cin >> N >> M ;
	for(i=0;i<N;i++) cin >> a[i] >> b[i];
	for(j=0;j<M;j++) cin >> c[j] >> d[j];

	for(i=0;i<N;i++){
		s = abs(a[i]-c[0])+abs(b[i]-d[0]);
		ans = 1;
		for(j=1;j<M;j++){
			if(s > abs(a[i]-c[j]) + abs(b[i]-d[j])){
				s = abs(a[i]-c[j])+abs(b[i]-d[j]);
				ans = j+1;
			}
		}
		cout << ans << endl;	
	}	
}
