#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int M;
int memo[512][16][512][4][2];
string limit;

int f(int pos , int digit , int mod , int up , int free){
	if(pos == -1) return (mod == 0);
	if(memo[pos][digit][mod][up][free] != -1) return memo[pos][digit][mod][up][free];
	int ans = 0;
	if(up != 2){
		if(up){
			for(int i = digit+1 ; i <= (free?9:limit[pos]) ; i++){
				ans += f(pos-1,i,(mod*10+i)%M,up^1,free||(i < limit[pos]));
			}
		}else{
			for(int i = (free?digit-1:min((int)limit[pos],digit-1)) ; i >= 0 ; i--){
				ans += f(pos-1,i,(mod*10+i)%M,up^1,free||(i < limit[pos]));
			}
		}
	}else{
		ans += f(pos-1,0,(mod*10+0)%M,2,free||(0 < limit[pos]));
		for(int i = 1 ; i <= (free?9:limit[pos]) ; i++){
			ans += f(pos-1,i,(mod*10+i)%M,0,free||(i < limit[pos]));
			if(pos != 0) ans += f(pos-1,i,(mod*10+i)%M,1,free||(i < limit[pos]));
		}
	}
	ans %= 10000;
	return memo[pos][digit][mod][up][free] = ans;
}

int solve(string n){
	memset(memo,-1,sizeof(memo));
	limit = "0" + n;
	reverse(limit.begin(),limit.end());
	for(int i = 0 ; i < limit.size() ; i++) limit[i] -= '0';
	return f(limit.size()-1,0,0,2,0) - 1;
}

int zig(string s){
	if(s.size() == 1) return true;
	if(s[0] == s[1]) return false;
	if(s.size() == 2) return s[0] != s[1];
	int up = s[0] > s[1];
	for(int i = 2 ; i < s.size() ; i ++){
		if( s[i-1] == s[i] || (up && s[i-1] >= s[i]) || (!up && s[i-1] <= s[i]) ) return false;
		up^=1;
	}
	return true;
}

int main(){
	string A,B;
	cin >> A >> B >> M;
	
	cout << ( solve(B) - solve(A) + zig(A) + 100000) % 10000 << endl;
}