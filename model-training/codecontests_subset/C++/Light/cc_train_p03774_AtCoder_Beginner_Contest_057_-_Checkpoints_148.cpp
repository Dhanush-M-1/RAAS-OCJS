#include <iostream>
using namespace std;

int main() {
	int N, M; cin >> N >> M;
	int a[55], b[55], c[55], d[55];
	for(int i=0; i<N; ++i) cin >> a[i] >> b[i];
	for(int i=0; i<M; ++i) cin >> c[i] >> d[i];
	for(int i=0; i<N; ++i){
	    int P=abs(a[i]-c[0])+abs(b[i]-d[0]), Q=0;
	    for(int j=1; j<M; ++j){
	        int K=abs(a[i]-c[j])+abs(b[i]-d[j]);
	        if(P>K){
	            P=K;
	            Q=j;
	        }
	    }
	    cout << Q+1 << endl;
	}
	return 0;
}