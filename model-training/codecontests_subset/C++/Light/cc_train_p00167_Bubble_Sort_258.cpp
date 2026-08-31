#include<iostream>
#include<vector>
#include <algorithm>

using namespace std;
typedef long long ll;

#define rep(i,a) for(int i = 0 ; i < a ; i ++)

int main(void){
	int n;
	while(cin>>n,n){
		vector<int> v(n);
		rep(i,n)cin>>v[i];
		int cnt = 0;
		rep(i,n){
			for(int j = 0; j+1 < n-i; j++){
      	if(v[j] > v[j+1]){ 
      		swap(v[j],v[j+1]); 
      		cnt++;
      	}
      }
		}		

		cout<<cnt<<endl;
	}
	return 0;
}