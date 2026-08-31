#include <bits/stdc++.h>
using namespace std;
 
int main()
{
    int n,a[100],ans;
    cin>>n;
    
    for(int i=0;i<n;i++) cin>>a[i]; //n?????\???
     
    for(int i=0;i<n;i++){
        int m=i;
        for(int j=i+1;j<n;j++){
            if(a[j]<a[m]) m=j;
        }
        if(m!=i) ans++;
        swap(a[m],a[i]);
    }

    for(int i=0;i<n-1;i++) cout<<a[i]<<" ";
    cout<<a[n-1]<<endl;
    cout<<ans<<endl;
    return 0;
}