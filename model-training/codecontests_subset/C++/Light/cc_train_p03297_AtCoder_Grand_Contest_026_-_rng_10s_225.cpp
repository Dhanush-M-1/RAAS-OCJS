#include <bits/stdc++.h>

using namespace std;

typedef long long llint;

llint gcd(llint a, llint b)
{
	while (b)
	{
		tie(a, b) = make_pair(b, a % b);
	}
	
	return a;
}

bool solve()
{
	llint a, b, c, d, x;
	
	cin>>a>>b>>c>>d;
	
	if (a < b)
		return false;
	
	a %= b;
	
	if (a > c)
		return false;
	
	x = gcd(b, d);
	
	if (a % x + d < b)
		return false;
	
	return b - x + a % x <= c;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	
	int t;
	
	cin>>t;
	
	while (t--)
	{
		cout<<(solve() ? "Yes\n" : "No\n");
	}
}
