// B - Checkpoints
#include <bits/stdc++.h>
using namespace std;

int main(){
	int n,m; cin>>n>>m;

	vector<int> SX(n), SY(n), CX(m), CY(m), ans(n);

	for(int s=0; s<n; s++) cin>>SX[s]>>SY[s];
	for(int c=0; c<m; c++) cin>>CX[c]>>CY[c];

	for(int s=0; s<n; s++){
		int mini = 1e9;
		for(int c=0; c<m; c++){
			int m  = abs(SX[s]-CX[c]) + abs(SY[s]-CY[c]);
			if(mini>m){
				mini = m;
				ans[s] = c+1;
			}
		}
	}

	for(int s=0; s<n; s++) cout<<ans[s]<<"\n";
}