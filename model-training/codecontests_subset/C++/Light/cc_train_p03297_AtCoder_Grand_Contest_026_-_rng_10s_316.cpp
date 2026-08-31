#include <iostream>
using namespace std;
long long gcd(long long a, long long b) {
    if (a < b) swap(a, b);
    while (b > 0) { long long t = a; a = b; b = t % b; }
    return a;
}
int main() {
    int t; cin >> t;
    while (t--) {
        long long A, B, C, D; cin >> A >> B >> C >> D;
        if (A < B || B > D) cout << "No\n";
        else if (B-1 <= C) cout << "Yes\n";
        else {
            long long g = gcd(B, D);
            cout << (C + 1 > A % B + (B - A % B - 1) / g * g ? "Yes\n" : "No\n");
        }
    }
}
