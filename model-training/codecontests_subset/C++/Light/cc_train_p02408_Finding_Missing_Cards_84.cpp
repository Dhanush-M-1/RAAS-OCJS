#include <bits/stdc++.h>

using namespace std;

map<pair<char, int>, char> m;
char suits[] = {'S', 'H', 'C', 'D'};

int main(){

	ios::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;

	char suit;
	int rank;
	for(int i=0;i<n;++i) {
		cin >> suit >> rank;
		m[make_pair(suit,rank)] = 'X';
	}
	for(int i=0;i<4;++i)
		for(int j=1;j<=13;++j)
			if(m[make_pair(suits[i],j)]!='X')
				cout << suits[i] << ' ' << j << '\n';
	return 0;

} // br1

