#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void solve(int k, int n, int m, vector<int> M, vector<int> P){
	int i=0,j=0;
	vector<int> ans;
	while(true){
		if(i==n && j==m){
			// done 
			for(auto a: ans){
				cout << a << " ";
			}
			cout << endl;
			return;
		}
		if(i<n && M[i] == 0){
			ans.push_back(0);
			i++;
			k++;
		}
		else if(j<m && P[j]==0){
			ans.push_back(0);
			j++;
			k++;
		}
		else if( i<n && M[i] <= k){
			ans.push_back(M[i]);
			i++;
		}
		else if(j<m &&  P[j] <=k){
			ans.push_back(P[j]);
			j++;
		}
		else{
			cout << -1 << endl;
			return;
		}
		
	}
}

int main(){
	int t;
	cin>>t;
	int k,n,m;
	string temp;
	while(t--){
		getline(cin, temp);
		scanf("%d %d %d",&k, &n, &m);
		vector<int> M(n,0);
		vector<int> P(m,0);
		int temp=0;
		for(int i=0;i<n;i++){
			cin>>temp;
			M[i] = temp;
		}
		for(int i=0;i<m;i++){
			cin>>temp;
			P[i] = temp;
		}
		
		// for(auto a: M){
		// 	cout << a << " ";
		// }
		// cout << endl;
		// for(auto b: P){
		// 	cout << b << " "; 
		// }
		// cout << endl;
		solve(k,n,m,M,P);
	}
	return 0;	
}