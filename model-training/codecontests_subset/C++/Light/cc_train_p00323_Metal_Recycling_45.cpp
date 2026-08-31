#include <bits/stdc++.h>
using LL = long long;
using namespace std;
#define DBG(x) ; // cerr<<#x<<" = "<<x<<endl
#define rep(i,n) for(int i=0;i<(n);++i)

LL N;

int main()
{
	cin >> N;
	std::vector<LL>a(N), b(N);
	rep(i, N) cin >> a[i] >> b[i];
	
	std::priority_queue<LL, std::vector<LL>, std::greater<LL>>c;
	rep(i, N) c.push(a[i] + b[i]);
	
	while(!c.empty())
	{
		LL num1 = c.top(); c.pop();
		if (c.empty())
		{
			cout << num1 << " 0" << endl;
			break;
		}
		LL num2 = c.top();
		if (num1 == num2)
		{
			c.pop();
			c.push(num1 + 1);
		}
		else cout << num1 << " 0" << endl;
	}
	return 0;
}
