// JOI 2011-2012 予選6
#include<iostream>
#include<string>
#include<vector>
#include<cstring>

// 多倍長整数
std::vector<int> A, B;
int M;
// memo[現在i桁目][Mで割った余り][直前の数字][直前が増加・減少(0: 増, 1: 減, 2: 上から0が連続][自由に選べるか]
int memo[501][500][10][3][2];

// メモ化再帰
// (vで表される数)以下のZig-Zag数の個数を10000で割った余りを返す
int rec( const std::vector<int>& v, int n, int mod, int prv, int ud, bool ok )
{
	if( n == v.size() )
		return !mod;

	if( memo[n][mod][prv][ud][ok] >= 0 )
		return memo[n][mod][prv][ud][ok];

	int ret = 0;
	
	for( int i = 0; i <= ( ok ? 9 : v[n] ); ++i )
	{
		if( !ud && prv <= i )
			continue;
		if( ud == 1 && prv >= i )
			continue;
		if( ud == 2 && prv && prv == i )
			continue;

		int nud;
		if( ud == 2 )
		{
			if( !prv )
				nud = 2;
			else if( prv > i )
				nud = 1;
			else
				nud = 0;
		}
		else
			nud = !ud;

		ret += rec( v, n + 1, ( mod * 10 + i ) % M, i, nud, ok | i != v[n] );
	}

	return memo[n][mod][prv][ud][ok] = ret % 10000;
}

int main()
{
	std::string s, t;
	std::cin >> s >> t >> M;
	for( int i = 0; i != s.size(); ++i )
		A.push_back( s[i] - '0' );
	for( int i = 0; i != t.size(); ++i )
		B.push_back( t[i] - '0' );

	// A - 1をする
	// c: carry
	int c = 1;
	for( int i = A.size() - 1; i >= 0; --i )
	{
		A[i] -= c;
		c = 0;

		if( A[i] < 0 )
		{
			c = 1;
			A[i] += 10;
		}
	}

	memset( memo, -1, sizeof( memo ) );
	int a = rec( A, 0, 0, 0, 2, 0 );
	memset( memo, -1, sizeof( memo ) );
	int b = rec( B, 0, 0, 0, 2, 0 );

	// 10000で割った余りなので、f( B ) < f( A - 1 )の可能性あり
	std::cout << ( 10000 + b - a ) % 10000 << std::endl;

	return 0;
}