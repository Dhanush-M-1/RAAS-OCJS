#include <iostream>
using namespace std;

int main(){
	int N, M;
	cin >> N >> M;
	int a[N], b[N], c[M], d[M];
	for(int i=0; i<N; i++){
		cin >> a[i] >> b[i];
	}
	for(int i=0; i<M; i++){
		cin >> c[i] >> d[i];
	}
	for(int i=0; i<N; i++){
		int min_dist=abs(a[i]-c[0])+abs(b[i]-d[0]),ans=1;
		for(int j=1; j<M; j++){
			int cur_dist=abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(min_dist>cur_dist){
				min_dist = cur_dist;
				ans=j+1;
			}
		}
		cout << ans << endl;
	}
}
