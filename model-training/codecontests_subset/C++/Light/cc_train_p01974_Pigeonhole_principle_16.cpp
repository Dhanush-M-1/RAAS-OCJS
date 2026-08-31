#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin >> n;
    int a[n];
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
            int sa = (int)abs(a[i] - a[j]);
            if(!(sa % (n - 1))){
                cout << a[i] << " " << a[j] << endl;
                return 0;
            }
        }
    }
}
