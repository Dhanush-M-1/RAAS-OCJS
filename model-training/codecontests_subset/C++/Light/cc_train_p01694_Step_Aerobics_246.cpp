
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
string s;
int n;


bool solve(){
	cin >> n;
	if(n == 0){
		return false;
	}
	int flag = 0;
	int a =0, b= 0;
	int ans = 0;
	for(int i=0;i<n;i++){
		cin >> s;
		if(s == "lu"){
			a = 1;
		}else if(s == "ru"){
			b = 1;
		}else if(s == "ld"){
			a = 0;
		}else{
			b = 0;
		}
		if(!flag && a == 1 && b == 1){
			ans++;
			flag = 1;
		}else if(flag && a == 0 && b == 0){
			ans++;
			flag = 0;
		}
	}
	cout << ans << endl;
	return true;
}



int main(){
	while(solve());
}
