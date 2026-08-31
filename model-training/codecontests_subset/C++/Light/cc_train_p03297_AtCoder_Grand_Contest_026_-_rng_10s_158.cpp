#include <cstdio>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

long long gcd(long long a, long long b) {
    return b == 0 ? a : gcd(b, a % b);
}

int main()
{
    int T;
    long long A, B, C, D;
    cin >> T;
    while (T--) {
        cin >> A >> B >> C >> D;
        if (A < B || D < B) cout << "No\n";
        else {
            long long g = gcd(B, D);
            if (B - (g - A % g) > C) cout << "No\n";
            else cout << "Yes\n";
        }
    }

    return 0;
}
