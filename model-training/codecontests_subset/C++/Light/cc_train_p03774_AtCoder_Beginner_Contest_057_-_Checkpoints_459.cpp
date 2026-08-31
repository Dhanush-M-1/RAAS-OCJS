// B - Checkpoints
#include <bits/stdc++.h>
using namespace std;

int main(){
	int n,m; cin>>n>>m;

	vector<int> SX(n), SY(n), CX(m), CY(m);

	for(int s=0; s<n; s++) cin>>SX[s]>>SY[s];
	for(int c=0; c<m; c++) cin>>CX[c]>>CY[c];

	for(int s=0; s<n; s++){
		int mini = 1e9, ans = 0;
		for(int c=0; c<m; c++){
			int m  = abs(SX[s]-CX[c]) + abs(SY[s]-CY[c]);
			if(mini>m){ mini = m; ans = c+1; }
		}
		cout<< ans <<endl;
	}
}