// Chekpoints
#include <iostream>
#include <math.h>
using namespace std;

int n,m;
int a[50],b[50],c[50],d[50];

int main(){
    cin>>n>>m;
    for(int i=0;i<n;i++){
        cin>>a[i]>>b[i];
    }for(int i=0;i<m;i++){
        cin>>c[i]>>d[i];
    }
    for(int i=0;i<n;i++){
        int Min=0;
        for(int j=0;j<m;j++){
            if(abs(a[i]-c[Min])+abs(b[i]-d[Min])>abs(a[i]-c[j])+abs(b[i]-d[j]))
                Min=j;
        }
        cout<<Min+1<<endl;
    }
    return 0;
}