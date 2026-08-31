#include <bits/stdc++.h>
using namespace std;


void solve(string N){

	  int l = N.size();
	  int ans = 0;
	  while(l>1){
			int maxi = 0;
			for(int i=1; i<l; i++){
				  int pre = stoi( N.substr(0,i) );
				  int suf = stoi( N.substr(i,l-i) );
				  maxi = max(maxi,pre*suf);
			}
			N = to_string(maxi);
			l = N.size();
			ans++;
	  }
	  cout << ans << endl;

}


int main(){

	  int Q; cin >> Q;
	  for(int i=0; i<Q; i++){
			string N; cin >> N;
			solve(N);
	  }

}