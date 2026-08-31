#include <bits/stdc++.h>
using namespace std;

int N;

void dfs( string s, char cm )
{
	if( s.size() == N ) {
		cout << s << endl;
	}
	else {
		for( char c = 'a'; c <= cm; c++ ) {
			char cc = cm;
			if( c == cm ) cc = cm + 1;
			dfs( s + c, cc );
		}
	}
}

int main()
{
	cin >> N;

	dfs( "", 'a' );

}
