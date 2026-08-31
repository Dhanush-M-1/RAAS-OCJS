
#include<cstdio>
#include<iostream>
#include<algorithm>
#include<string>
#include<cstring>
#include<queue>
#include<vector>
#include<functional>
#include<cmath>
#include<map>
#include<stack>
#include<set>
#include<numeric>
#include<limits>
#include<iomanip>
#include<iterator>

#define all(x) (x).begin(),(x).end()
#define rall(x) (x).rbegin(),(x).rend()
#define rep(i,n) for(int i=0; i<n; i++)
#define FOR(i,a,n) for(int i=a; i<n; i++)

using namespace std;
typedef long long ll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;
typedef pair<ll, char> plc;

int N;
priority_queue<int,vector<int>,greater<int> > pq;

int main()
{	
	cin >> N;
	rep(i, N) {
		int a, b;
		cin >> a >> b;
		pq.push(a + b);
	}

	while (!pq.empty()) {
		if (pq.size() <= 1) {
			cout << pq.top() << " " << 0 << endl;
			break;
		}
		int a = pq.top(); pq.pop();
		int b = pq.top(); pq.pop(); 
		if (a == b)pq.push(a + 1);
		else {
			cout << a << " " << 0 << endl;
			pq.push(b);
		}
	}
	return 0;
}