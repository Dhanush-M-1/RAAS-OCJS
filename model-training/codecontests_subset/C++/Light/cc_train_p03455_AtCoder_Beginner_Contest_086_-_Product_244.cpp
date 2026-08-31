#include <iostream>
using namespace std;
int a,b;
int main()
{
    cin>>a>>b;
    cout<<((a&1)&&(b&1)?"Odd\n":"Even\n");
    return 0;
}