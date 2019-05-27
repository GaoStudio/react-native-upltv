using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Upltv.RNUpltv
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNUpltvModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNUpltvModule"/>.
        /// </summary>
        internal RNUpltvModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNUpltv";
            }
        }
    }
}
