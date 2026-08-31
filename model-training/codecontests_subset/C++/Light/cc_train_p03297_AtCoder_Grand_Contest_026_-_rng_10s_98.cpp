#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;
inline long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }

bool solve() {
    long long a, b, c, d; cin >> a >> b >> c >> d;
    if (a < b) return false;
    if (d < b) return false;
    long long g = gcd(b, d);
    long long rem = a % g;
    long long mi = (c - rem + g) / g * g + rem;
    return mi >= b;
}

int main() {
    int T; cin >> T;
    while (T--) {
        cout << (solve() ? "Yes" : "No") << endl;
    }
    return 0;
}
