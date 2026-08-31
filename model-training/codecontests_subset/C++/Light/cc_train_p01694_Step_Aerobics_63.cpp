#include <iostream>

using namespace std;

int main() {
    int n;
    string f[101];

    while (cin >> n) {
        if (!n) { break; }

        for (int i = 0; i < n; i++) { cin >> f[i]; }

        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (f[i] == "lu" && f[i-1] == "ru") { ans++;}
            else if (f[i] == "ru" && f[i-1] == "lu") { ans++; }
            else if (f[i] == "ld" && f[i-1] == "rd") { ans++; }
            else if (f[i] == "rd" && f[i-1] == "ld") { ans++; }
        }
        cout << ans << endl;
    }
    return 0;
}
