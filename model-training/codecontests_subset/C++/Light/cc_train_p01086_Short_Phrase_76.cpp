#include <bits/stdc++.h>
using namespace std;



bool check(vector<int>& v, int i){

	  vector<int> x = {5,7,5,7,7};
	  int id=0;
	  for(int j=i; j<v.size(); j++){

			x[id] -= v[j];
			if( x[id] == 0 ){
				  id++;
				  if(id == 5) return true;
			}
			else if( x[id] < 0 ){
				  return false;
			}
	  }
	  return false;


}


int main(){
	  while(1){
			int n; cin >> n;
			if(!n) break;

			vector<int> v(n);
			for(int i=0; i<n; i++){
				  string in; cin >> in;
				  v[i] = in.size();
			}
			for(int i=0; i<n; i++){
				  if( check(v,i) ){
						cout << i+1 << endl;
						break;
				  }
			}
			
	  }
}