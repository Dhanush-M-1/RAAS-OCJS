#include <iostream>
#include <map>
#include <cstdlib>
#include <sstream>
using namespace std;
int main(){
	int Q;
	cin >>Q;
	while(Q--){
		int n;
		cin >>n;
		map<int,int>memo;
		int ans = 0;
		while(!memo[n] && n >= 10){
			memo[n] =true;
			int next = 0;
			stringstream ss;
			ss << n;
			string t =ss.str();
			for(int i = 0 ; i < t.size()-1 ; i++){
				string a = t.substr(0,i+1);
				string b = t.substr(i+1);
				int A = atoi(a.c_str());
				int B = atoi(b.c_str());
				next = max(next,A*B);
			}
			ans++;
			n = next;
		}
		if( n >= 10 ){
			cout << -1 << endl;
		}else{
			cout << ans << endl;
		}
	}
}