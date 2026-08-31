#include <bits/stdc++.h>
using namespace std;

void solve(string &S, int k, char c){
	if(k == S.size()){
		cout << S << endl;
		return;
	}
	for(char x = 'a'; x <= c + 1; x++){
		S[k] = x;
		solve(S, k + 1, max(c, x));
	}
}

int main(){
	int N;
	scanf("%d", &N);
	string S(N, '$');
	solve(S, 0, 'a' - 1);
	return 0;
}