#include <bits/stdc++.h>

using namespace std;

int main() {

    int n;
    string w[40];
    int lens[] = {5, 7, 5, 7, 7};

    while(cin >> n, n) {

        for(int i = 0; i < n; ++i) {
            cin >> w[i];
        }

        for(int i = 0; i < n; ++i) {

            int len = 0, phrase = 0;

            for(int j = i; j < n; ++j) {

                len += w[j].size();

                if(len == lens[phrase]) {
                    len = 0;
                    ++phrase;
                    if(phrase == 5) {
                        cout << i + 1 << endl;
                        break;
                    }
                }
            }

            if(phrase == 5) {
                break;
            }

        }

    }

}