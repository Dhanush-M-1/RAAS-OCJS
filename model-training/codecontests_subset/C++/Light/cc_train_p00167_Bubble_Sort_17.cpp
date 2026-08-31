#include <iostream>
using namespace std;
int main(){
    int n;
    while(cin >>n){
        if(n==0)
            break;
        int a[n];
        for(int i=0;i<n;i++)
            cin >> a[i];
        int time=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int tmp;
                    tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                    time++;
                }
            }
        }
        cout << time << endl;
    }
}