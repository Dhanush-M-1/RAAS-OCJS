#include<iostream>

using namespace std;

int main(){
    int n,min;
    int cnt = 0;
    int a[100];
    cin >> n;
    for(int i=0;i<n;i++) cin >> a[i];
    for(int i=0;i<n;i++){
        min =i;
        for(int j=i;j<n;j++){
            if(a[j]<a[min]) min=j;
        }
        if(a[i]>a[min]){
        swap(a[i],a[min]);
        cnt++;
        }
    }
    cout << a[0];
    for(int i=1;i<n;i++) cout <<" "<< a[i];
    cout << endl;
    cout << cnt << endl;
}
