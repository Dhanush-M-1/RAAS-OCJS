#include <bits/stdc++.h>
#define ll long long
using namespace std;

ll n;
ll a, b, c, d, g;

ll gcd(ll x, ll y){
	return y == 0 ? x : gcd(y, x % y);
}

int main(){

cin >> n;

while (n--){
    cin >> a >> b >> c >> d;
    if (a < b || d < b) cout << "No\n";
    else if (c >= b) cout << "Yes\n";
    else {
        g = gcd(b, d);
        if (b - g + a % g > c) cout << "No\n";
        else cout << "Yes\n";
    }
}

return 0;
} 