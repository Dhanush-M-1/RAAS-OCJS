#include <iostream>
using namespace std;

using ll = long long;

const string YES = "Yes", NO = "No";

ll gcd(ll a, ll b) { return b == 0 ? a : gcd(b, a%b); }

ll A, B, C, D;

string solve() {
    if (A < B || B > D) return NO;
    if (B <= C) return YES;
    ll v = gcd(D, B);
    return B - v + (A % v) <= C ? YES : NO;
}

int main(void) {
    int T; cin >> T;
    for (int i = 0; i < T; ++i) {
        cin >> A >> B >> C >> D;
        cout << solve() << endl;
    }
    return 0;
}
