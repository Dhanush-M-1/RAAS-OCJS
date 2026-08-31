#include <bits/stdc++.h>
using namespace std;

using db = double;
using ll = long long;
using vi = vector <int>;
#define op operator
#define pb push_back

struct poi {
	db x, y;
	poi op -(poi p) {
		return {x - p.x, y - p.y};
	}
	db cross(poi p) {
		return x * p.y - y * p.x;
	}
}p[4];
db xmul(poi a, poi b, poi c) {
	return (b - a).cross(c - a);
}

int main() {
	ios :: sync_with_stdio(0);

	while(cin >> p[0].x) {
		char c; cin >> c >> p[0].y;
		for(int i = 1; i < 4; i ++)
			cin >> c >> p[i].x >> c >> p[i].y;
		int c1 = 0, c2 = 0;
		for(int i = 0; i < 4; i ++)
			if(xmul(p[i], p[(i + 1) % 4], p[(i + 2) % 4]) > 0)
				c1 ++;
			else
				c2 ++;
		cout << (!c1 || !c2 ? "YES" : "NO") << '\n';
	}
	
	return 0;
}