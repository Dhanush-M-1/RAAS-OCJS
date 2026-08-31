#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;

    while(1) {
        cin >> n;
        if(n == 0) break;

        vector<string> w(n);

        for(int i = 0; i < n; i++) {
            cin >> w[i];
        }

        for(int i = 0; i < n; i++) {
            vector<int> tanku{ 5, 7, 5 ,7, 7 };
            int k = 0;
            for(int j = 0; i+j < n; j++) {
                tanku[k] -= w[i+j].size();
                if(tanku[k] == 0) k++;
                else if(tanku[k] < 0) break;
            }
            if(tanku[0] == 0 && tanku[1] == 0 
            && tanku[2] == 0 && tanku[3] == 0 
            && tanku[4] == 0) {
                cout << i+1 << endl;
                break;
            }
            else continue;
        }
    }
    return 0;
}
