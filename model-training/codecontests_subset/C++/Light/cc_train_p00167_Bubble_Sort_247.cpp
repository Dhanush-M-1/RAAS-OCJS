#include <iostream>
using namespace std;
int a[100];
int main(){
    int n;
    while(cin>>n && n){
        int ans=0;
        for(int i=0;i<n;i++){
            cin>>a[i];
            for(int j=0;j<i;j++){
                if(a[j]>a[i])ans++;
            }
        }
        cout << ans << endl;
    }
}